package edu.mum.cs.lab7ormjpa;

import edu.mum.cs.lab7ormjpa.model.ClassRoom;
import edu.mum.cs.lab7ormjpa.model.Student;
import edu.mum.cs.lab7ormjpa.model.Transcript;
import edu.mum.cs.lab7ormjpa.repository.ClassRoomRepository;
import edu.mum.cs.lab7ormjpa.repository.StudentRepository;
import edu.mum.cs.lab7ormjpa.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Lab7ormjpaApplication  implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;
     @Autowired
    private TranscriptRepository transcriptRepository;
     @Autowired
     private ClassRoomRepository classRoomRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab7ormjpaApplication.class, args);
    }


    Student saveStudent(Student student) {
        return repository.save(student);
    }
    Transcript saveTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

    ClassRoom saveClassRoom(ClassRoom classRoom){
        return classRoomRepository.save(classRoom);
    }
    @Override
    public void run(String... args) throws Exception {
        Transcript transcript= new Transcript("BS Computer Science");
        Transcript studentTranscript= saveTranscript(transcript);

        ClassRoom classRoom=new ClassRoom("McLaughling Building","M105");
        ClassRoom studentClassRoom= saveClassRoom(classRoom);
        Student st = new Student("000-61-0001","Anna","Lynn","Smith",3.45F, LocalDate.of(2019,5,24));
        st.setTranscript(studentTranscript);
        st.setClassRoom(studentClassRoom);
        Student enrolledStudent= saveStudent(st);
        System.out.println(enrolledStudent);
    }
}
