package JAXB;


import AccesoDatos.Alumno;
import generated.ALUMNOS;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public final class XMLJAXB {

    File file;
    ArrayList<Alumno> listaAlumno = new ArrayList<>();

    public XMLJAXB(Alumno a) {
        file = new File("src/java/Ficheros/Salida.xml");
        listaAlumno.add(a);
        imprimirAlumno();
    }

    public void imprimirAlumno() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ALUMNOS.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(listaAlumno, file);
        } catch (JAXBException e) {
        }
    }
}
