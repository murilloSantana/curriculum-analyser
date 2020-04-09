FROM adoptopenjdk/openjdk13-openj9:jdk-13.0.2_8_openj9-0.18.0
COPY src/main/resources/doc /tmp/doc
COPY build/libs/curriculum-analyser-*-all.jar curriculum-analyser.jar
RUN apt-get update
RUN apt-get install -y libxt6 libxrender1
RUN apt-get clean

WORKDIR /tmp
RUN apt-get install wget
RUN wget http://netcologne.dl.sourceforge.net/project/openofficeorg.mirror/4.1.1/binaries/en-US/Apache_OpenOffice_4.1.1_Linux_x86-64_install-deb_en-US.tar.gz
RUN tar xf Apache_OpenOffice_4.1.1_Linux_x86-64_install-deb_en-US.tar.gz

WORKDIR /tmp/en-US/DEBS

RUN dpkg -i *.deb

WORKDIR /opt/openoffice4/program

RUN rm -rf /tmp/en-US /tmp/Apache_OpenOffice_4.1.1_Linux_x86-64_install-deb_en-US.tar.gz

RUN useradd -ms /bin/bash soffice
USER soffice

WORKDIR /

EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-XX:+IdleTuningGcOnIdle", "-Xtune:virtualized", "-jar", "curriculum-analyser.jar"]
