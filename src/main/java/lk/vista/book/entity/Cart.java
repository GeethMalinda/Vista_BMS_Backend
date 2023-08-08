package lk.vista.book.entity;

import lombok.Data;

import javax.persistence.*;


public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookDetail book;

    @Column(nullable = false)
    private int quantity;

    // Add getters and setters
}
