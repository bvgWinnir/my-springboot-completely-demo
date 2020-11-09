package com.bvgol.service;

import com.bvgol.pojo.Druid;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Classname DruidServiceImpl
 * @Description TODO
 * @Date 2020/11/9 14:11
 * @Created by GUOCHEN
 */

@Service
public class DruidServiceImpl implements DruidService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int deleteByPrimaryKey(Integer id) {

        String sql = "delete from durid where id =" + id;
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insert(Druid record) {
        StringBuilder sb = new StringBuilder(32);
        String sql = "insert into druid (`name`,localDate,sex,version) value (";
        sb.append(sql)
                .append("'")
                .append(record.getName() + "--" + LocalDateTime.now())
                .append("','")
                .append(LocalDateTime.now())
                .append("',")
                .append(record.getSex())
                .append(",")
                .append(0)
                .append(");");

        System.out.println(sb.toString());
        sql = sb.toString();
        try {
            jdbcTemplate.execute(sql);

            List<Map<String, Object>> lastInsert = this.findLastInsert();
            String s = lastInsert.get(0).get("LAST_INSERT_ID()").toString();
            return Integer.valueOf(s);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertOrUpdate(Druid record) {
        String sql = "";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertOrUpdateSelective(Druid record) {
        String sql = "";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertSelective(Druid record) {
        String sql = "";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Druid selectByPrimaryKey(Integer id) {
        String sql = "select * from druid where id=" + id;
        try {
            RowMapper<Druid> tRowMapper = new RowMapper<Druid>() {
                @Override
                public Druid mapRow(ResultSet rs, int rowNum) throws SQLException {
                    if (rowNum < 2) {
                        int id1 = rs.getInt("id");
                        String name = rs.getString("name");
                        Date localDate = rs.getDate("localDate");
//                        byte sexes = rs.getByte("sex");
                        int version = rs.getInt("version");

                        return Druid.builder()
                                .id(id1)
                                .name(name)
//                                .sex(sexes)
                                .version(version)
                                .build();
                    } else {
                        //这个方法中不会出现
                        return null;
                    }

                }
            };
            List<Druid> query = jdbcTemplate.query(sql, tRowMapper);
//            if (!CollectionUtils.isEmpty(query)){return query.get(0);}
            return Optional.ofNullable(query.get(0)).get();

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Druid record) {
        String sql = "";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Druid record) {
        String sql = "";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateBatch(List<Druid> list) {
        String sql = "";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateBatchSelective(List<Druid> list) {
        String sql = "";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int batchInsert(List<Druid> list) {
        String sql = "";
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Map<String, Object>> findLastInsert() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select LAST_INSERT_ID();");
        maps.forEach((l) -> {
            l.forEach((k, v) -> {
                System.out.println(k + "--" + v);
            });
        });
        return maps;
    }

    @Override
    public Object error() {
        jdbcTemplate.execute("seleeeee");
        return null;
    }
}
