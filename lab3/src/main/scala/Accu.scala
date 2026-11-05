import chisel3._

class Accu extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val setZero = Input(Bool())
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  val sum = RegInit(0.U(8.W))
  when (io.setZero) {
    sum := 0.U
  } .otherwise {
    sum := sum + io.din
  }
  res := sum

  // ***** your code ends here *****

  io.dout := res
}