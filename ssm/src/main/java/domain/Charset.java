package domain;

import lombok.Data;

// information_schema数据库的CHARACTER_SETS表
@Data
public class Charset {
    private String CHARACTER_SET_NAME;
    private String DEFAULT_COLLATE_NAME;
}