DESCRIPTION = "The future of online communications. "
SECTION = "base"
#HOMEPAGE = "https://tox.im/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README.md;md5=89669ee5d8c0ccca5e0a62f4570957d5"


SRC_URI = "git://github.com/TMRh20/RF24.git;protocol=https \
	file://Makefile.patch"

SRCREV = "16c49cbbf33cc4ad31ffeb09e835768385880665"

S = "${WORKDIR}/git/"


EXTRA_OEMAKE =+ "includedir=${includedir} libdir=${libdir}"



do_compile () {
	oe_runmake DESTDIR=${D} PREFIX=${stagedir}
}



do_install(){
	oe_libinstall -so librf24-bcm ${D}${libdir}
	install -d ${D}${includedir}


	install -d ${D}${includedir}/RF24
	install -m 0644 *.h ${D}${includedir}/RF24/

	install -d ${D}${includedir}/RF24/arch
	install -d ${D}${includedir}/RF24/arch/RPi
	install -m 0644 arch/RPi/*.h ${D}${includedir}/RF24/arch/RPi
	install -m 0644 arch/RPi/*.h ${D}${includedir}/RF24/arch/

}

