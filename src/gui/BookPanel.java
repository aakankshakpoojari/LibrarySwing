package gui;
import service.LibraryService;
import model.Book;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

public class BookPanel extends JPanel {
    private LibraryService service;
    private JTable bookTable;
    private JTextField searchField;
    
    public BookPanel(LibraryService service) {
        this.service = service;
        setLayout(new BorderLayout());
        
        // Load sample data first
        service.addBook(new model.FictionBook("F1", "Harry Potter", "JK Rowling"));
        service.addBook(new model.TextBook("T1", "Java OOP", "Author"));
        service.addBook(new model.FictionBook("F2", "Lord of Rings", "Tolkien"));
        
        // Top controls
        JPanel topPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchBtn = new JButton("🔍 Search");
        JButton refreshBtn = new JButton("📚 Refresh");
        
        searchBtn.addActionListener(e -> updateTable(searchField.getText()));
        refreshBtn.addActionListener(e -> updateTable(""));
        
        topPanel.add(new JLabel("Search Title:"));
        topPanel.add(searchField);
        topPanel.add(searchBtn);
        topPanel.add(refreshBtn);
        add(topPanel, BorderLayout.NORTH);
        
        // Data table (bound to ArrayList)
        bookTable = new JTable();
        bookTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
        add(new JScrollPane(bookTable), BorderLayout.CENTER);
        
        updateTable("");  // Show all books
    }
    
    private void updateTable(String search) {
        List<Book> books = search.isEmpty() ? 
            service.getAllBooks() : service.searchBooks(search);
            
        bookTable.setModel(new AbstractTableModel() {
            public int getRowCount() { return books.size(); }
            public int getColumnCount() { return 3; }
            public Object getValueAt(int row, int col) {
                Book b = books.get(row);
                return switch(col) {
                    case 0 -> b.getIsbn();
                    case 1 -> b.getTitle();
                    case 2 -> b.getAuthor();
                    default -> "";
                };
            }
            @Override
            public String getColumnName(int col) {
                return switch(col) {
                    case 0 -> "ISBN";
                    case 1 -> "Title";
                    case 2 -> "Author";
                    default -> "";
                };
            }
        });
    }
}



