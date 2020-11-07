package Hospital.multithreading;

import java.util.ArrayList;
import java.util.List;

public class HospitalRoom {

    private Integer doctorCount = 0;
    private Integer patientCount = 0;
    private String doctorName="";
    List<String> patientList = new ArrayList<>();
    private Integer logger = 0;


    public boolean doctorEnter(Doctor d) throws InterruptedException {

        synchronized(this.doctorCount) {
            if (this.doctorCount == 0) {
                this.doctorCount++;
                this.doctorName = d.name;

                    this.log("Doctor " + this.doctorName + " Entered, number of doctor " + this.doctorCount);

                return true;
            }

            //synchronized (this.logger) {
                this.log("Doctor " + d.name + " is waiting to Enter, number of doctor " + this.doctorCount);
            //}
            return false;

        }
    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        synchronized(this.doctorCount) {
            if (this.doctorName.equals(d.name) && this.doctorCount > 0) {
                this.doctorCount--;
                this.log("Doctor " + this.doctorName + " left, number of doctor " + this.doctorCount);
                this.doctorName = "";
                return true;
            }

            return false;
        }
    }

    public  boolean patientEnter(Patient p) throws InterruptedException {

        synchronized (this.patientCount) {
            if (this.patientCount < 3) {
                this.patientCount = this.patientCount + 1;
                patientList.add(p.name);
                this.log("Patient " + p.name + " entered, number of patients " + patientCount);
                //System.out.println("@@@@---Patient in hospital " + patientList);
                return true;
            }
                //System.out.println("@@@@--Patient in hospital " + patientList);

                this.log("Patient " + p.name + " is waiting to enter, number of patients " + patientCount);

            return false;
        }
    }
    public boolean patientLeave(Patient p) throws InterruptedException {

        synchronized (this.patientCount) {
            if (patientCount > 0) {
                for (int i = 0; i < patientList.size(); i++) {
                    if (patientList.get(i).equals(p.name)) {
                        patientCount--;
                        this.log("Patient " + p.name + " left, number of patients " + patientCount);
                        patientList.remove(p.name);
                    }
                }

                //System.out.println("@@@@--Patient in hospital after " + p.name + "left " + patientList);
                return true;
            }

           // System.out.println("@@@@--Patient in hospital" + patientList);
            return false;
        }
    }

    synchronized static private void log(String msg) {
          try {
              Thread.sleep(500);
          } catch (Exception e) {

          }
          System.out.println(msg);
    }

}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}

class Main2 {
    public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(siva)) {}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient1 = new Thread(() -> {
            try {
                while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }
}

//Doctor siva Entered, number of doctor 1
//Patient p1 entered, number of patients 1
//Doctor john is waiting to Enter, number of doctor 1
//Patient p4 entered, number of patients 2
//Patient p3 entered, number of patients 3
//Patient p2 is waiting to enter, number of patients 3
//Patient p5 is waiting to enter, number of patients 3
//Patient p4left
//Doctor siva Left, number of doctor 0
//Patient p2 entered, number of patients 3
//Doctor john Entered, number of doctor 1
//Patient p3left
//Patient p1left
//Patient p5 entered, number of patients 2
//Patient p2left
//Doctor john Left, number of doctor 0
//Patient p5left