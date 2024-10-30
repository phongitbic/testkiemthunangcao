package ThiThu1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Sach")
public class Sach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "SoTrang")
    private Integer soTrang;

    @Column(name = "DonGia")
    private Long donGia;

    @ManyToOne
    @JoinColumn(name = "IdNXB", referencedColumnName = "ID")
    private NhaXuatBan nhaXuatBan;


    @Column(name = "TrangThai")
    private Integer trangThai;
}
