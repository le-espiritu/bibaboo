package com.project.bibaboo.domain.alterations.dto;

// 페이지 이동 인터페이스 구현을 위한 데이터를 담는 DTO 클래스
public class PageDTO {

  private int startPage; // 화면에 표시되는 시작 페이지
  private int endPage; // 화면에 표시되는 끝 페이지
  private boolean prev; // 이전 페이지 존재 유무
  private boolean next; // 다음 페이지 존재 유무
  private int total; // 전체 게시물 수
  private int blockLimit; // 화면 하단에 보여줄 페이지 번호 갯수
  private Criteria criteria;

  public PageDTO(Criteria criteria, int total) {
    
    this.blockLimit = 10; // 페이지 번호 갯수를 10이라는 기본값으로 설정
    
    this.criteria = criteria;
    this.total = total;

    this.startPage =
        (((int) (Math.ceil((double) criteria.getPageNum() / blockLimit))) - 1) * blockLimit + 1;
    this.endPage = startPage + blockLimit - 1;

    // 전체 페이지
    int maxPage = (int) (Math.ceil((double) total / criteria.getAmount()));

    // 위에서 구해진 화면 하단의 마지막 페이지가 전체 페이지수보다 크다면, 마지막 페이지수를 전체 페이지수로 조정한다.
    if (maxPage < this.endPage) {
      this.endPage = maxPage;
    }

    // startPage값이 1보다 큰 경우 true로 초기화
    this.prev = this.startPage > 1;

    // endPage 값이 maxPage보다 작은 경우 true로 초기화
    this.next = this.endPage < maxPage;
  }

  public int getStartPage() {
    return startPage;
  }

  public void setStartPage(int startPage) {
    this.startPage = startPage;
  }

  public int getEndPage() {
    return endPage;
  }

  public void setEndPage(int endPage) {
    this.endPage = endPage;
  }

  public boolean isPrev() {
    return prev;
  }

  public void setPrev(boolean prev) {
    this.prev = prev;
  }

  public boolean isNext() {
    return next;
  }

  public void setNext(boolean next) {
    this.next = next;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getBlockLimit() {
    return blockLimit;
  }

  public void setBlockLimit(int blockLimit) {
    this.blockLimit = blockLimit;
  }

  public Criteria getCriteria() {
    return criteria;
  }

  public void setCriteria(Criteria criteria) {
    this.criteria = criteria;
  }

  @Override
  public String toString() {
    return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next="
        + next + ", total=" + total + ", blockLimit=" + blockLimit + ", criteria=" + criteria + "]";
  }

}
