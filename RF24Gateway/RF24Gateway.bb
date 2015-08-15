DESCRIPTION = "The future of online communications. "
SECTION = "base"
#HOMEPAGE = "https://tox.im/"
LICENSE = "GPLv2+"
DEPENDS="RF24"
LIC_FILES_CHKSUM = "file://Readme.md;md5=d58d428e9e2c9288be6c24bea78618be"


SRC_URI = "git://github.com/TMRh20/RF24Gateway.git;protocol=https \
	file://Makefile.patch"

SRCREV = "68dc95d2fa4988832a47e74a532fa35541f4014b"

S = "${WORKDIR}/git/"


EXTRA_OEMAKE =+ "prefix=${prefix} includedir=${includedir} libdir=${libdir} CXXFLAGS=-std=c++11"



do_compile () {
	oe_runmake DESTDIR=${D} PREFIX=${stagedir}
}


do_install(){
	oe_libinstall -so librf24gateway ${D}${libdir}
	install -d ${D}${includedir}/
	install -d ${D}${includedir}/RF24Gateway
	install -m 0644 *.h ${D}${includedir}/RF24Gateway/
}
