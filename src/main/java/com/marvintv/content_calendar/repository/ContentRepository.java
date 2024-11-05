package com.marvintv.content_calendar.repository;


import com.marvintv.content_calendar.model.Content;
import com.marvintv.content_calendar.model.Type;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {




}
