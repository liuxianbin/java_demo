package service.impl;

import com.mysql.cj.util.StringUtils;
import domain.Charset;
import mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ICharsetService;

import java.util.Objects;

@Service
public class CharsetServiceImpl implements ICharsetService {
    @Autowired
    private HelloMapper helloMapper;

    @Override
    public String getCharacterCollateName(String name) {
        String cName = "nil";
        if (!StringUtils.isNullOrEmpty(name)) {
            Charset c = helloMapper.getCharset(name);
            if (!Objects.isNull(c)) {
                cName = c.getDEFAULT_COLLATE_NAME();
            }
        }
        return cName;
    }
}
