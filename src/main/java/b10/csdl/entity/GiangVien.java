package b10.csdl.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GiangVien {
    private String maGV;
    private String ten;
    private String loai;
    private int tuoi;
    private int bac;
    private Boolean gioiTinh;
}
