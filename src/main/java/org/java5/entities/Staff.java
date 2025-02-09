package org.java5.entities;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Staff {
    @NotBlank(message = "Chưa nhập Email")
    @Email(message = "Email chưa đúng định dạng")
    private String id;

    @NotBlank(message = "Chưa nhập họ và tên")
    private String fullname;

    @Builder.Default
    private String photo = "Thuy.png";

    @NotNull(message = "Chưa chọn giới tính")
//    private Boolean gender = true;
    private Boolean gender;

    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "Ngày sinh không hợp lệ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
//    private Date birthday = new Date();
    private Date birthday;

    @Min(value = 1000, message = "Lương tối thiểu phải là 1000")
    @NotNull(message = "Chưa nhập lương")
//    private Double salary = 12345.6789;
    private Double salary;

    @Builder.Default
    private Integer level = 0;
}

