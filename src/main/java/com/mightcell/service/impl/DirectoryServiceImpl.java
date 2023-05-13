package com.mightcell.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mightcell.entity.Directory;
import com.mightcell.mapper.DirectoryMapper;
import com.mightcell.service.DirectoryService;
import org.springframework.stereotype.Service;

/**
 * @author 修雯天
 */
@Service
public class DirectoryServiceImpl extends ServiceImpl<DirectoryMapper, Directory> implements DirectoryService {
}
