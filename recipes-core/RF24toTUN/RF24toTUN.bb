DESCRIPTION = "The future of online communications. "
SECTION = "examples"
#HOMEPAGE = "https://tox.im/"
LICENSE = "GPLv2+"
DEPENDS = "RF24 RF24Network boost"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c0ff450a466d46a42a2c75e0849c586"


SRC_URI = "git://github.com/reixd/RF24toTUN.git;protocol=https \
	file://Makefile.patch"

SRCREV = "3d39692a74641b3ab4536dd0d4075b622cbbe901"

S = "${WORKDIR}/git/"


EXTRA_OEMAKE =+ "prefix=${prefix} includedir=${includedir} libdir=${libdir}"



do_compile () {
	oe_runmake DESTDIR=${D} PREFIX=${stagedir}
}


do_install(){
	install -d ${D}${bindir}
	install -m 0755 rf24totun ${D}${bindir}
	install -m 0755 rf24totun_configAndPing.sh ${D}${bindir}

}

