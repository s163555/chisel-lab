create_project -in_memory -part xc7a35tcpg236-1
read_verilog generated/Mux4.v
read_xdc Mux4.xdc
synth_design -top Mux4 -part xc7a35tcpg236-1
opt_design
place_design
route_design
write_bitstream -force Mux4.bit