import chisel3._

class MaxFinderWithIndex extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(4.W))
    val b = Input(UInt(4.W))
    val c = Input(UInt(4.W))
    val d = Input(UInt(4.W))
    val max = Output(UInt(4.W))
    val idx = Output(UInt(2.W))
  })

  val a = io.a
  val b = io.b
  val c = io.c
  val d = io.d
  val maxVal = WireDefault(0.U(4.W))

  val condAB = io.a > io.b
  val maxAB = Mux(condAB, io.a, io.b)
  val idxAB = Mux(condAB, 0.U(2.W), 1.U(2.W))

  val condCD = io.c > io.d
  val maxCD = Mux(condCD, io.c, io.d)
  val idxCD = Mux(condCD, 2.U(2.W), 3.U(2.W))

  val condFinal = maxAB > maxCD
  io.max := Mux(condFinal, maxAB, maxCD)
  io.idx := Mux(condFinal, idxAB, idxCD)

}

/* 
class MaxFinder extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(4.W))
    val b = Input(UInt(4.W))
    val c = Input(UInt(4.W))
    val d = Input(UInt(4.W))
    val max = Output(UInt(4.W))
  })

  val a = io.a
  val b = io.b
  val c = io.c
  val d = io.d
  val max = WireDefault(0.U(4.W))
  /* First version
  val maxAB = Mux(io.a > io.b, io.a, io.b) // Mux 1 + Comparator 1
  val maxCD = Mux(io.c > io.d, io.c, io.d) // Mux 2 + Comparator 2
  val maxVal = Mux(maxAB > maxCD, maxAB, maxCD) // Mux 3 + Comparator 3

  io.max := maxVal*/
 */