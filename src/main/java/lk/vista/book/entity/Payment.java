package lk.vista.book.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


public class Payment {

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
    private Date date;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String paymentMethod;

    // getters and setters
}
