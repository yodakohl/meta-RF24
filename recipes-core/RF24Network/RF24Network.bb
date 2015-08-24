DESCRIPTION = "The future of online communications. "
SECTION = "base"
#HOMEPAGE = "https://tox.im/"
LICENSE = "GPLv2+"
DEPENDS="RF24"
LIC_FILES_CHKSUM = "file://README.md;md5=77dbce41488fe3dc7d9a01b1ff91a9ae"


SRC_URI = "git://github.com/TMRh20/RF24Network.git;branch=Development;protocol=https \
	file://Makefile.patch "

SRCREV = "e60d6eac7ca43541f40ca55362dadd3529f59ec1"

S = "${WORKDIR}/git/"


EXTRA_OEMAKE =+ "prefix=${prefix} includedir=${includedir} libdir=${libdir}"



do_compile () {
    oe_runmake DESTDIR=${D} PREFIX=${stagedir}
}


do_install(){
	oe_libinstall -so librf24network ${D}${libdir}
	install -d ${D}${includedir}/
	install -m 0644 RF24Network.h ${D}${includedir}/
	install -m 0644 RF24Network_config.h ${D}${includedir}/


	install -d ${D}${includedir}/RF24Network
	install -m 0644 RF24Network.h ${D}${includedir}/RF24Network/
	install -m 0644 RF24Network_config.h ${D}${includedir}/RF24Network/

}
