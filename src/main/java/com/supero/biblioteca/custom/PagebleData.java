/**
 * 
 */
package com.supero.biblioteca.custom;

import com.supero.biblioteca.dto.LivroFilterDTO;

/**
 * @author bruno.freiberger
 *
 */
public class PagebleData {

	private CustomPageable pageable;
	private LivroFilterDTO filter;
	private Sort sort;

	public CustomPageable getPageable() {
		return pageable;
	}

	public void setPageable(CustomPageable pageable) {
		this.pageable = pageable;
	}

	public LivroFilterDTO getFilter() {
		return filter;
	}

	public void setFilter(LivroFilterDTO filter) {
		this.filter = filter;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
}
