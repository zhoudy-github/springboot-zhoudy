package com.zhoudy.springboot.usermanage.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersonPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonPoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFirstIsNull() {
            addCriterion("first is null");
            return (Criteria) this;
        }

        public Criteria andFirstIsNotNull() {
            addCriterion("first is not null");
            return (Criteria) this;
        }

        public Criteria andFirstEqualTo(String value) {
            addCriterion("first =", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotEqualTo(String value) {
            addCriterion("first <>", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstGreaterThan(String value) {
            addCriterion("first >", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstGreaterThanOrEqualTo(String value) {
            addCriterion("first >=", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLessThan(String value) {
            addCriterion("first <", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLessThanOrEqualTo(String value) {
            addCriterion("first <=", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstLike(String value) {
            addCriterion("first like", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotLike(String value) {
            addCriterion("first not like", value, "first");
            return (Criteria) this;
        }

        public Criteria andFirstIn(List<String> values) {
            addCriterion("first in", values, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotIn(List<String> values) {
            addCriterion("first not in", values, "first");
            return (Criteria) this;
        }

        public Criteria andFirstBetween(String value1, String value2) {
            addCriterion("first between", value1, value2, "first");
            return (Criteria) this;
        }

        public Criteria andFirstNotBetween(String value1, String value2) {
            addCriterion("first not between", value1, value2, "first");
            return (Criteria) this;
        }

        public Criteria andLastIsNull() {
            addCriterion("last is null");
            return (Criteria) this;
        }

        public Criteria andLastIsNotNull() {
            addCriterion("last is not null");
            return (Criteria) this;
        }

        public Criteria andLastEqualTo(String value) {
            addCriterion("last =", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotEqualTo(String value) {
            addCriterion("last <>", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThan(String value) {
            addCriterion("last >", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThanOrEqualTo(String value) {
            addCriterion("last >=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThan(String value) {
            addCriterion("last <", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThanOrEqualTo(String value) {
            addCriterion("last <=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLike(String value) {
            addCriterion("last like", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotLike(String value) {
            addCriterion("last not like", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastIn(List<String> values) {
            addCriterion("last in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotIn(List<String> values) {
            addCriterion("last not in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastBetween(String value1, String value2) {
            addCriterion("last between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotBetween(String value1, String value2) {
            addCriterion("last not between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andDateofbirthIsNull() {
            addCriterion("dateofbirth is null");
            return (Criteria) this;
        }

        public Criteria andDateofbirthIsNotNull() {
            addCriterion("dateofbirth is not null");
            return (Criteria) this;
        }

        public Criteria andDateofbirthEqualTo(Date value) {
            addCriterionForJDBCDate("dateofbirth =", value, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("dateofbirth <>", value, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthGreaterThan(Date value) {
            addCriterionForJDBCDate("dateofbirth >", value, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dateofbirth >=", value, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthLessThan(Date value) {
            addCriterionForJDBCDate("dateofbirth <", value, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dateofbirth <=", value, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthIn(List<Date> values) {
            addCriterionForJDBCDate("dateofbirth in", values, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("dateofbirth not in", values, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dateofbirth between", value1, value2, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andDateofbirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dateofbirth not between", value1, value2, "dateofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthIsNull() {
            addCriterion("placeofbirth is null");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthIsNotNull() {
            addCriterion("placeofbirth is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthEqualTo(String value) {
            addCriterion("placeofbirth =", value, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthNotEqualTo(String value) {
            addCriterion("placeofbirth <>", value, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthGreaterThan(String value) {
            addCriterion("placeofbirth >", value, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthGreaterThanOrEqualTo(String value) {
            addCriterion("placeofbirth >=", value, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthLessThan(String value) {
            addCriterion("placeofbirth <", value, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthLessThanOrEqualTo(String value) {
            addCriterion("placeofbirth <=", value, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthLike(String value) {
            addCriterion("placeofbirth like", value, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthNotLike(String value) {
            addCriterion("placeofbirth not like", value, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthIn(List<String> values) {
            addCriterion("placeofbirth in", values, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthNotIn(List<String> values) {
            addCriterion("placeofbirth not in", values, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthBetween(String value1, String value2) {
            addCriterion("placeofbirth between", value1, value2, "placeofbirth");
            return (Criteria) this;
        }

        public Criteria andPlaceofbirthNotBetween(String value1, String value2) {
            addCriterion("placeofbirth not between", value1, value2, "placeofbirth");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}