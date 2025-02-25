package com.osmanbatuhankalkan.project_step2_file;

import com.osmanbatuhankalkan.project_step1_file.StudentDto;
import com.osmanbatuhankalkan.utils.SpecialColor;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// Öğrenci Yönetim Sistemi
public class StudentManagementSystem {

    // Field
    private ArrayList<StudentDto> studentDtoList = new ArrayList<>();
    private int studentCounter = 0;
    private static final String FILE_NAME = "students.txt";

    // static
    static {

    }

    // Parametresiz Constructor
    public StudentManagementSystem() {
        // Program başlarken Öğrenci Listesini hemen yüklesin
        loadStudentsListFromFile();
    }

    ////////////////////////////////////////////////////////////////
    // Login
    // Register

    /// /////////////////////////////////////////////////////////////
    // FileIO Create
    // File Create
    private void saveToFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(studentDtoList);
        } catch (IOException io) {
            System.out.println(SpecialColor.RED + " Dosya Ekleme Hatası" + SpecialColor.RESET);
            io.printStackTrace();
        }
    }

    // File Read
    // Öğrenci Listesini Yükle (Dosya)
    private void loadStudentsListFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentDtoList = (ArrayList<StudentDto>) objectInputStream.readObject();
            studentCounter = studentDtoList.size();
            System.out.println(SpecialColor.BLUE + " Dosyadan Yüklenen Öğrenci sayısı: " + studentCounter);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(SpecialColor.RED + " Dosyadan yüklenen Öğren Kayıdı bulunamadı " + SpecialColor.RESET);
            fileNotFoundException.printStackTrace();
        } catch (IOException io) {
            System.out.println(SpecialColor.RED + " Dosya Okuma Hatası" + SpecialColor.RESET);
            io.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /// /////////////////////////////////////////////////////////////
    // C-R-U-D
    // Öğrenci Ekle

    /// Integer id, String name, String surname, Double midTerm, Double finalTerm, LocalDate birthDate
    public void add(StudentDto dto) {
        studentDtoList.add(
                new StudentDto(++studentCounter, dto.getName(), dto.getSurname(), dto.getMidTerm(), dto.getFinalTerm(), dto.getBirthDate())
        );
        System.out.println(SpecialColor.YELLOW + " Öğrenci Eklendi" + SpecialColor.RESET);
        // File Ekle
        saveToFile();
    }

    // Öğrenci Listesi
    public void list() {
        // Öğrenci Yoksa
        if (studentDtoList.isEmpty()) {
            System.out.println(SpecialColor.RED + " Öğrenci yoktur" + SpecialColor.RESET);
            return;
        } else {
            System.out.println(SpecialColor.BLUE + " Öğrenci Listesi" + SpecialColor.RESET);
            studentDtoList.forEach(System.out::println);
        }
    }

    // Öğrenci Ara
    public void search(String name) {
         /* studentDtoList.stream()
                .filter(temp -> temp.getName().equalsIgnoreCase(name))
                .forEach(System.out::println); */
        // Eğer Öğrenci varsa true dönder
        boolean found = studentDtoList
                .stream()
                .filter(temp -> temp.getName().equalsIgnoreCase(name))
                .peek(System.out::println) // Eğer ilgili data varsa yazdır
                .findAny() // Herhangi bir eşleşen öğrenci var mı yok mu ? kontrol et
                .isPresent();

        // Öğrenci Yoksa
        if (!found) {
            throw new StudentNotFoundException(name + " isimli Öğrenci bulunamadı");
        }
    }

    // Öğrenci Güncelle
    public void update(int id, StudentDto dto) {
        for (StudentDto temp : studentDtoList) {
            if (temp.getId() == id) {
                temp.setName(dto.getName());
                temp.setSurname(dto.getSurname());
                temp.setBirthDate(dto.getBirthDate());
                temp.setMidTerm(dto.getMidTerm());
                temp.setFinalTerm(dto.getFinalTerm());
                // Güncellenmiş Öğrenci Bilgileri
                System.out.println(SpecialColor.BLUE + temp + " Öğrenci Bilgileri Güncellendi" + SpecialColor.RESET);
                // Dosyaya kaydet
                saveToFile();
                return;
            }
        }
        System.out.println(SpecialColor.RED + " Öğrenci Bulunamadı" + SpecialColor.RESET);
    }

    // Öğrenci Sil
    public void delete(int id) {
        //studentDtoList.removeIf(temp -> temp.getId() == id);
        boolean removed = studentDtoList.removeIf(temp -> temp.getId() == id);
        if (removed) {
            System.out.println(SpecialColor.BLUE + "Öğrenci Silindi" + SpecialColor.RESET);
            // Silinen Öğrenciyi dosyaya kaydet
            saveToFile();
        } else {
            System.out.println(SpecialColor.RED + "Öğrenci Silinmedi" + SpecialColor.RESET);
        }
    }

    ////////////////////////////////////////////////////////////////
    // Toplam Öğrenci Sayısı
    // Rastgele Öğrenci
    // Öğrenci Not Ortalaması Hesapla
    // En Yüksek veya En Düşük Not Alan Öğrenci
    // Öğrenci Sıralaması (Doğum günü)

    /// /////////////////////////////////////////////////////////////
    // Console Seçim (Öğrenci)
    public void chooise() {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        // Sonsuz while
        while (true) {
            System.out.println(SpecialColor.YELLOW+ "\n1.Öğrenci Ekle");
            System.out.println("2.Öğrenci Listele");
            System.out.println("3.Öğrenci Ara");
            System.out.println("4.Öğrenci Güncelle");
            System.out.println("5.Öğrenci Sil");
            System.out.println("6.Öğrenci toplam öğrenci sayısı");
            System.out.println("7.Öğrenci rastgele gelsin");
            System.out.println("8.Öğrenci Not Hesapla");
            System.out.println("9.Öğrenci En Yüksek, En düşük Notları Göster");
            System.out.println("10.Öğrenci Öğrenci Sıralaması Doğum gününe göre göster");
            System.out.println("11.Çıkış"+SpecialColor.RESET);
            System.out.println(SpecialColor.CYAN+"Lütfen Seçiminizi Yapınız"+SpecialColor.RESET);

            // Seçim yap
            int chooise = scanner.nextInt();
            scanner.nextLine(); // durma yerimiz

            // Karar
            switch (chooise) {
                case 1: // Öğrenci Ekle
                    System.out.println("Öğrenci Adı");
                    String name = scanner.nextLine();

                    System.out.println("Öğrenci Soyadı");
                    String surname = scanner.nextLine();

                    System.out.println("Öğrenci Doğum tarihi YYYY-MM-DD");
                    LocalDate birthDate = LocalDate.parse(scanner.nextLine());

                    System.out.println("Vize Puanı");
                    double midTerm = scanner.nextDouble();

                    System.out.println("Final Puanı");
                    double finalTerm = scanner.nextDouble();

                    // Integer id, String name, String surname, Double midTerm, Double finalTerm, LocalDate birthDate
                    studentManagementSystem.add(new StudentDto(++studentCounter, name, surname, midTerm, finalTerm, birthDate));
                    break;
                case 2: // Öğrenci Listelemek
                    studentManagementSystem.list();
                    break;

                case 3: // Öğrenci Ara
                    studentManagementSystem.list();
                    System.out.println(SpecialColor.BLUE + " Aranacak Öğrenci ismi yazınız "+SpecialColor.RESET);
                    String searchName = scanner.nextLine();
                    studentManagementSystem.search(searchName);
                    break;

                case 4: // Öğrenci Güncelle
                    studentManagementSystem.list();
                    System.out.println("Güncelleme yapılacak Öğrenci ID'si giriniz");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Eğer int sonrası String gelecekse bunu yazmalıyız.

                    System.out.println("Yeni Öğrenci Adı");
                    String nameUpdate = scanner.nextLine();

                    System.out.println("Yeni Öğrenci Soyadı");
                    String surnameUpdate = scanner.nextLine();

                    System.out.println("Öğrenci Doğum tarihi YYYY-MM-DD");
                    LocalDate birthDateUpdate = LocalDate.parse(scanner.nextLine());

                    System.out.println("Vize Puanı");
                    double midTermUpdate = scanner.nextDouble();

                    System.out.println("Final Puanı");
                    double finalTermUpdate = scanner.nextDouble();

                    // Integer id, String name, String surname, Double midTerm, Double finalTerm, LocalDate birthDate
                    StudentDto studentDtoUpdate = StudentDto.builder()
                            .name(nameUpdate)
                            .surname(surnameUpdate)
                            .midTerm(midTermUpdate)
                            .finalTerm(finalTermUpdate)
                            .birthDate(birthDateUpdate)
                            .build();
                    try {
                        studentManagementSystem.update(id, studentDtoUpdate);
                    } catch (StudentNotFoundException e) {
                        System.out.println(SpecialColor.RED + e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case 5: // Öğrenci Sil
                    studentManagementSystem.list();
                    System.out.println(SpecialColor.BLUE + " Silinecek Öğrenci ID");
                    int deleteID = scanner.nextInt();
                    studentManagementSystem.delete(deleteID);
                    break;

                case 6:
                    System.out.println("case 6");
                    break;
                case 7:
                    System.out.println("case 7");
                    break;
                case 8:
                    System.out.println("case 8");
                    break;
                case 9:
                    System.out.println("case 9");
                    break;
                case 10:
                    System.out.println("case 10");
                    break;
                case 11:
                    System.out.println("Sistemden çıkış yapılıyor");
                    System.exit(0);
                    //return;  //bunu yazarsak break gerek yoktur
                    break;
                default:
                    System.out.println("Geçersiz seçim yaptınız! Lütfen tekrar deneyiniz ");
                    break;
            }
        }
    }

}