package seuri;

import javax.swing.*;  // 모든 Swing 컴포넌트 임포트
import java.awt.event.*;  // 이벤트 리스너 임포트
import java.io.*;  // 파일 입출력 관련 클래스 임포트
import java.util.ArrayList;  // ArrayList 사용을 위해 임포트

public class dasdasd {
    
    private static ArrayList<Book> books = new ArrayList<>();
    private static final String FILE_PATH = "C:/Users/seulmin/git/repository3/qweqwe/datafile"; // 데이터 저장할 파일 경로

    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Absolute layout 사용
        
        // 책 제목 입력 필드
        JLabel labelTitle = new JLabel("Title:");
        labelTitle.setBounds(20, 20, 50, 25);
        JTextField fieldTitle = new JTextField();
        fieldTitle.setBounds(80, 20, 150, 25);
        
        // 저자 입력 필드
        JLabel labelAuthor = new JLabel("Author:");
        labelAuthor.setBounds(20, 60, 50, 25);
        JTextField fieldAuthor = new JTextField();
        fieldAuthor.setBounds(80, 60, 150, 25);
        
        // 책 추가 버튼
        JButton addButton = new JButton("Add Book");
        addButton.setBounds(80, 100, 150, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = fieldTitle.getText();
                String author = fieldAuthor.getText();
                if (!title.isEmpty() && !author.isEmpty()) {
                    Book book = new Book(title, author);
                    books.add(book);
                    saveBooksToFile(); // 책 정보를 파일에 저장
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                    fieldTitle.setText("");
                    fieldAuthor.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in both fields.");
                }
            }
        });
        
        // 도서 목록 보기 버튼
        JButton viewButton = new JButton("View Books");
        viewButton.setBounds(80, 140, 150, 25);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBooksFromFile(); // 파일에서 도서 정보 불러오기
                JTextArea textArea = new JTextArea();
                for (Book book : books) {
                    textArea.append(book.toString() + "\n");
                }
                JOptionPane.showMessageDialog(frame, new JScrollPane(textArea), "Book List", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // 구성 요소를 프레임에 추가
        frame.add(labelTitle);
        frame.add(fieldTitle);
        frame.add(labelAuthor);
        frame.add(fieldAuthor);
        frame.add(addButton);
        frame.add(viewButton);
        
        // 프레임 보이기
        frame.setVisible(true);
        
        // 프로그램 실행 시 파일에서 도서 목록 불러오기
        loadBooksFromFile();
    }
    
    // Book 클래스 정의
    static class Book {
        private String title;
        private String author;
        
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
        
        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author;
        }
    }

    // 책 정보를 파일에 저장하는 메서드
    private static void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                writer.write(book.title + "," + book.author);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 책 정보를 불러오는 메서드
    private static void loadBooksFromFile() {
        books.clear(); // 리스트 초기화
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        books.add(new Book(parts[0], parts[1]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


public class dasdasd {
    
    private static ArrayList<Book> books = new ArrayList<>();
    private static final String FILE_PATH = "books.txt"; // 데이터 저장할 파일 경로

    public static void main(String[] args) {
        // JFrame 생성
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Absolute layout 사용
        
        // 책 제목 입력 필드
        JLabel labelTitle = new JLabel("Title:");
        labelTitle.setBounds(20, 20, 50, 25);
        JTextField fieldTitle = new JTextField();
        fieldTitle.setBounds(80, 20, 150, 25);
        
        // 저자 입력 필드
        JLabel labelAuthor = new JLabel("Author:");
        labelAuthor.setBounds(20, 60, 50, 25);
        JTextField fieldAuthor = new JTextField();
        fieldAuthor.setBounds(80, 60, 150, 25);
        
        // 책 추가 버튼
        JButton addButton = new JButton("Add Book");
        addButton.setBounds(80, 100, 150, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = fieldTitle.getText();
                String author = fieldAuthor.getText();
                if (!title.isEmpty() && !author.isEmpty()) {
                    Book book = new Book(title, author);
                    books.add(book);
                    saveBooksToFile(); // 책 정보를 파일에 저장
                    JOptionPane.showMessageDialog(frame, "Book added successfully!");
                    fieldTitle.setText("");
                    fieldAuthor.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in both fields.");
                }
            }
        });
        
        // 도서 목록 보기 버튼
        JButton viewButton = new JButton("View Books");
        viewButton.setBounds(80, 140, 150, 25);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBooksFromFile(); // 파일에서 도서 정보 불러오기
                JTextArea textArea = new JTextArea();
                for (Book book : books) {
                    textArea.append(book.toString() + "\n");
                }
                JOptionPane.showMessageDialog(frame, new JScrollPane(textArea), "Book List", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // 구성 요소를 프레임에 추가
        frame.add(labelTitle);
        frame.add(fieldTitle);
        frame.add(labelAuthor);
        frame.add(fieldAuthor);
        frame.add(addButton);
        frame.add(viewButton);
        
        // 프레임 보이기
        frame.setVisible(true);
        
        // 프로그램 실행 시 파일에서 도서 목록 불러오기
        loadBooksFromFile();
    }
    
    // Book 클래스 정의
    static class Book {
        private String title;
        private String author;
        
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
        
        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author;
        }
    }

    // 책 정보를 파일에 저장하는 메서드
    private static void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                writer.write(book.title + "," + book.author);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 책 정보를 불러오는 메서드
    private static void loadBooksFromFile() {
        books.clear(); // 리스트 초기화
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        books.add(new Book(parts[0], parts[1]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
