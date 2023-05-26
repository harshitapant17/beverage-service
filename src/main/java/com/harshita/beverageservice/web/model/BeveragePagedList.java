package com.harshita.beverageservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeveragePagedList extends PageImpl<BeverageDTO> {

    public BeveragePagedList(List<BeverageDTO> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeveragePagedList(List<BeverageDTO> content) {
        super(content);
    }
}
