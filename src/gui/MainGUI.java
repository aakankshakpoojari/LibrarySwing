package gui;
import service.LibraryService;
import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    private LibraryService service = LibraryService.getInstance();
    
    public MainGUI() {
        setTitle("Library Management System - OOP + Data Structures Demo");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center on screen
        
        // Tabbed pane navigation (Swing syllabus topic)
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("📚 Books", new BookPanel(service));     // ArrayList/HashMap demo
        tabs.addTab("📋 Issue Queue", new IssuePanel(service));  // Queue demo  
        tabs.addTab("👤 Users", new UserPanel(service));     // Stack demo
        
        add(tabs, BorderLayout.CENTER);
        
        // Status bar showing DS operations
        JLabel status = new JLabel("Ready | Books: " + service.getAllBooks().size());
        add(status, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        // Swing best practice: Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new MainGUI().setVisible(true);
        });
    }
}

