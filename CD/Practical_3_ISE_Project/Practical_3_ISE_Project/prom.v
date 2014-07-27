`timescale 1ns / 1ps

//    #    #     # ###         ######  ######  ####### #     # 
//   # #    #   #   #          #     # #     # #     # ##   ## 
//  #   #    # #    #          #     # #     # #     # # # # # 
// #     #    #     #          ######  ######  #     # #  #  # 
// #######   # #    #          #       #   #   #     # #     # 
// #     #  #   #   #          #       #    #  #     # #     # 
// #     # #     # ###         #       #     # ####### #     # 
//                     #######
//
// new, parameterizable, axi_prom module. 
// now obeys the width that fabric.vh sets. 

// (c) 2009 / 2010 Oscar Almer

module prom_ram_empty (clka, clkb, ena, wea, addra, ina, outa, enb, web, addrb, inb, outb);

input clka;
input clkb;
input ena;
input wea;
input [14:0] addra;
input [7:0] ina;
output reg [7:0] outa;
input enb;
input web;
input [14:0] addrb;
input [7:0] inb;
output reg [7:0] outb;

wire [7:0] outa0;
wire [7:0] outa1;
wire [7:0] outa2;
wire [7:0] outa3;
wire [7:0] outa4;

wire [7:0] outb0;
wire [7:0] outb1;
wire [7:0] outb2;
wire [7:0] outb3;
wire [7:0] outb4;

reg [2:0] old_addra;
reg [2:0] old_addrb;

always @(posedge clka)
begin
	old_addra <= addra[14:12];
end

always @(posedge clkb)
begin
	old_addrb <= addrb[14:12];
end



// select outputting RAM

always @ ( * )
begin
	outa = 8'h00;
	casez(old_addra)
	3'b000: outa = outa0;
	3'b001: outa = outa1;
	3'b010: outa = outa2;
	3'b011: outa = outa3;
	3'b100: outa = outa4;
	default: outa = 8'b00;
	endcase
end

always @ ( * )
begin
	outb = 8'h00;
	casez(old_addrb)
	3'b000: outb = outb0;
	3'b001: outb = outb1;
	3'b010: outb = outb2;
	3'b011: outb = outb3;
	3'b100: outb = outb4;
	default: outb = 8'b00;
	endcase
end

prom_ram_small  u_ram0 (
.clka(clka),
.clkb(clkb),
.ena(ena && (addra[14:12] == 3'b000) ),
.wea(wea && (addra[14:12] == 3'b000) ),
.addra(addra[11:0]),
.ina(ina),
.outa(outa0),
.enb(enb && (addrb[14:12] == 3'b000) ),
.web(web && (addrb[14:12] == 3'b000) ),
.addrb(addrb[11:0]),
.inb(inb),
.outb(outb0)
);
prom_ram_small  u_ram1 (
.clka(clka),
.clkb(clkb),
.ena(ena && (addra[14:12] == 3'b001) ),
.wea(wea && (addra[14:12] == 3'b001) ),
.addra(addra[11:0]),
.ina(ina),
.outa(outa1),
.enb(enb && (addrb[14:12] == 3'b001) ),
.web(web && (addrb[14:12] == 3'b001) ),
.addrb(addrb[11:0]),
.inb(inb),
.outb(outb1)
);
prom_ram_small  u_ram2 (
.clka(clka),
.clkb(clkb),
.ena(ena && (addra[14:12] == 3'b010) ),
.wea(wea && (addra[14:12] == 3'b010) ),
.addra(addra[11:0]),
.ina(ina),
.outa(outa2),
.enb(enb && (addrb[14:12] == 3'b010) ),
.web(web && (addrb[14:12] == 3'b010) ),
.addrb(addrb[11:0]),
.inb(inb),
.outb(outb2)
);
prom_ram_small  u_ram3 (
.clka(clka),
.clkb(clkb),
.ena(ena && (addra[14:12] == 3'b011) ),
.wea(wea && (addra[14:12] == 3'b011) ),
.addra(addra[11:0]),
.ina(ina),
.outa(outa3),
.enb(enb && (addrb[14:12] == 3'b011) ),
.web(web && (addrb[14:12] == 3'b011) ),
.addrb(addrb[11:0]),
.inb(inb),
.outb(outb3)
);
prom_ram_small  u_ram4 (
.clka(clka),
.clkb(clkb),
.ena(ena && (addra[14:12] == 3'b100) ),
.wea(wea && (addra[14:12] == 3'b100) ),
.addra(addra[11:0]),
.ina(ina),
.outa(outa4),
.enb(enb && (addrb[14:12] == 3'b100) ),
.web(web && (addrb[14:12] == 3'b100) ),
.addrb(addrb[11:0]),
.inb(inb),
.outb(outb4)
);

endmodule

module prom_ram_small(clka, clkb, ena, wea, addra, ina, outa, enb, web, addrb, inb, outb);

parameter RAM_WIDTH = 8;
parameter RAM_ADDR_BITS = 12;

input clka;
input clkb;
input ena;
input wea;
input enb;
input web;

reg [RAM_WIDTH-1:0] prom [0:(2**RAM_ADDR_BITS)-1];

//synthesis attribute ram_style of prom is block

// this small initial ensures that the ram is initialized to 0. 
// this is a FPGA optimization. 
integer i;

initial begin 
for( i = 0; i < (2**RAM_ADDR_BITS)-1; i = i + 1)
	prom[i] = 0; 
end

output reg [RAM_WIDTH-1:0] outa, outb;

input wire [RAM_ADDR_BITS-1:0] addra, addrb;
input wire [RAM_WIDTH-1:0] ina, inb;

always @(posedge clka) 
begin

  if (ena) 
  begin
    if (wea)
      prom[addra] <= ina;
    outa <= prom[addra];
  end
end

always @(posedge clkb) 
begin

  if (enb)
  begin
    if(web)
      prom[addrb] <= inb;
    outb <= prom[addrb];
  end
end



endmodule

