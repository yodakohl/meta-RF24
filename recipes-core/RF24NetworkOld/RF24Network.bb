DESCRIPTION = "The future of online communications. "
SECTION = "base"
LICENSE = "GPLv2+"
DEPENDS="RF24"
LIC_FILES_CHKSUM = "file://README.md;md5=3c055b7bad1dff3876d8985b0f835672"


SRC_URI = "git://github.com/TMRh20/RF24Network.git;protocol=https \
	file://Makefile.patch \
	file://RF42Network.cpp.patch"

SRCREV = "546e238897d0a0a5bd7b2c2b93ef48b3a0584845"

S = "${WORKDIR}/git"


EXTRA_OEMAKE =+ "prefix=${prefix} includedir=${includedir} libdir=${libdir}"



do_compile () {
	oe_runmake -C RPi/RF24Network DESTDIR=${D} PREFIX=${stagedir}
}


do_install(){
	oe_libinstall -C RPi/RF24Network -so librf24network ${D}${libdir}
	install -d ${D}${includedir}/
	install -d ${D}${includedir}/RF24Network
	install -m 0644 RPi/RF24Network/RF24Network.h ${D}${includedir}/RF24Network/
	install -m 0644 RPi/RF24Network/RF24Network_config.h ${D}${includedir}/RF24Network/

}
