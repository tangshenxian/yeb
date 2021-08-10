package com.shenxian.controller;


import com.shenxian.common.RespBean;
import com.shenxian.pojo.Joblevel;
import com.shenxian.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shenxian
 * @since 2021-07-23
 */
@RestController
@RequestMapping("/system/basic/jobLevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称信息")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels() {
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel) {
        joblevel.setCreatedate(LocalDateTime.now());
        if (joblevelService.save(joblevel)) {
            return RespBean.success().message("添加成功");
        }
        return RespBean.error().message("添加失败");
    }

    @ApiOperation(value = "更新职称信息")
    @PutMapping("/")
    public RespBean updateJobLevel(@RequestBody Joblevel joblevel) {
        if (joblevelService.updateById(joblevel)) {
            return RespBean.success().message("更新成功");
        }
        return RespBean.error().message("更新失败");
    }

    @ApiOperation(value = "删除职称信息")
    @DeleteMapping("/{id}")
    public RespBean deleteJobLevel(@PathVariable("id") Integer id) {
        if (joblevelService.removeById(id)) {
            return RespBean.success().message("删除成功");
        }
        return RespBean.error().message("删除失败");
    }

    @ApiOperation(value = "批量删除职称信息")
    @DeleteMapping("/")
    public RespBean deleteJobLevel(Integer[] ids) {
        if (joblevelService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success().message("批量删除成功");
        }
        return RespBean.error().message("批量删除失败");
    }
}
