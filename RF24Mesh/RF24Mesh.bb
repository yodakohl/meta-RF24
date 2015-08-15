DESCRIPTION = "The future of online communications. "
SECTION = "base"
#HOMEPAGE = "https://tox.im/"
LICENSE = "GPLv2+"
DEPENDS="RF24 RF24Network"
LIC_FILES_CHKSUM = "file://README.md;md5=ecfd54ceeb930d752852fd1513329e79"


SRC_URI = "git://github.com/TMRh20/RF24Mesh.git;protocol=https \
	file://Makefile.patch"

SRCREV = "1a9b0c9e31bb29777ca388a1f8e00101aa68e77c"

S = "${WORKDIR}/git/"


EXTRA_OEMAKE =+ "prefix=${prefix} includedir=${includedir} libdir=${libdir}"



do_compile () {
    oe_runmake DESTDIR=${D} PREFIX=${stagedir}
}


do_install(){
	oe_libinstall -so librf24mesh ${D}${libdir}
	install -d ${D}${includedir}/
	install -d ${D}${includedir}/RF24Mesh
	install -m 0644 *.h ${D}${includedir}/RF24Mesh
}
