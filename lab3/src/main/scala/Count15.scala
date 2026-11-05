import chisel3._

class Count15 extends Module {
  val io = IO(new Bundle {
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  val cnt = RegInit(0.U(8.W))

  when (cnt === 15.U) {
    cnt := 0.U
  } .otherwise {
    cnt := cnt + 1.U
  }
  res := cnt
  // ***** your code ends here *****

  io.dout := res
}