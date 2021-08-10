package com.shenxian.controller;


import com.shenxian.common.RespBean;
import com.shenxian.pojo.Position;
import com.shenxian.service.IPositionService;
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
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<Position> getAllPositions() {
        return positionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position) {
        position.setCreatedate(LocalDateTime.now());
        if (positionService.save(position)) {
            return RespBean.success().message("添加成功");
        }
        return RespBean.error().message("添加失败");
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position) {
        if (positionService.updateById(position)) {
            return RespBean.success().message("更新成功");
        }
        return RespBean.error().message("更新失败");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable("id") Integer id) {
        if (positionService.removeById(id)) {
            return RespBean.success().message("删除成功");
        }
        return RespBean.error().message("删除失败");
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/")
    public RespBean deletePosition(Integer[] ids) {
        if (positionService.removeByIds(Arrays.asList(ids))) {
            return RespBean.success().message("批量删除成功");
        }
        return RespBean.error().message("批量删除失败");
    }
}
