import chisel3._

/**
  * Use Mux2 components to build a 4:1 multiplexer
  */
  /* 
Stage 1                   Stage 2
     +------------+
a -->| a  Mux2_0  |
b -->| b   y      |---\
     |    sel     |    \     +------------+
     +------------+     |--->| a  Mux2_2  |
           |                 | b   y      |---> y
        sel(0)          /--->|    sel     |
     +------------+    /     +------------+
c -->| a  Mux2_1  |   /            |
d -->| b   y      |--/          sel(1)
     |    sel     |
     +------------+
           |
        sel(0)
 */

class Mux4 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val c = Input(UInt(1.W))
    val d = Input(UInt(1.W))
    val sel = Input(UInt(2.W))
    val y = Output(UInt(1.W))
  })

  // ***** your code starts here *****
  val m0 = Module(new Mux2)
  val m1 = Module(new Mux2)
  val m2 = Module(new Mux2)

  m0.io.a := io.a
  m0.io.b := io.b
  m0.io.sel := io.sel(0)

  m1.io.a := io.c
  m1.io.b := io.d
  m1.io.sel := io.sel(0)

  m2.io.a := m0.io.y
  m2.io.b := m1.io.y
  m2.io.sel := io.sel(1)

  io.y := m2.io.y
  // ***** your code ends here *****
}