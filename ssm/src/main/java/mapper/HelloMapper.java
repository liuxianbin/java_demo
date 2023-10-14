package mapper;

import domain.Charset;
import org.apache.ibatis.annotations.Param;

public interface HelloMapper {
    public Charset getCharset(@Param("name") String CHARACTER_SET_NAME);
}