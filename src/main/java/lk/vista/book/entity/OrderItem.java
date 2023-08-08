package lk.vista.book.entity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private BookDetail book;

    private int quantity;
    private BigDecimal price;
}
