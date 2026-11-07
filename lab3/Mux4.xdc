## Switches
set_property -dict { PACKAGE_PIN V17   IOSTANDARD LVCMOS33 } [get_ports { io_a }]
set_property -dict { PACKAGE_PIN V16   IOSTANDARD LVCMOS33 } [get_ports { io_b }]
set_property -dict { PACKAGE_PIN W16   IOSTANDARD LVCMOS33 } [get_ports { io_c }]
set_property -dict { PACKAGE_PIN W17   IOSTANDARD LVCMOS33 } [get_ports { io_d }]
set_property -dict { PACKAGE_PIN W15   IOSTANDARD LVCMOS33 } [get_ports { io_sel[0] }]
set_property -dict { PACKAGE_PIN V15   IOSTANDARD LVCMOS33 } [get_ports { io_sel[1] }]

## LED Output
set_property -dict { PACKAGE_PIN U16   IOSTANDARD LVCMOS33 } [get_ports { io_y }]