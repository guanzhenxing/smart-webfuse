package net.webfuse.uaa.user.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`PASSWORD` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`PASSWORD` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`PASSWORD` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`PASSWORD` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`PASSWORD` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`PASSWORD` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`PASSWORD` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`PASSWORD` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`PASSWORD` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`PASSWORD` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`PASSWORD` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`PASSWORD` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`PASSWORD` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`PASSWORD` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredIsNull() {
            addCriterion("ACCOUNT_NON_EXPIRED is null");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredIsNotNull() {
            addCriterion("ACCOUNT_NON_EXPIRED is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredEqualTo(Byte value) {
            addCriterion("ACCOUNT_NON_EXPIRED =", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredNotEqualTo(Byte value) {
            addCriterion("ACCOUNT_NON_EXPIRED <>", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredGreaterThan(Byte value) {
            addCriterion("ACCOUNT_NON_EXPIRED >", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredGreaterThanOrEqualTo(Byte value) {
            addCriterion("ACCOUNT_NON_EXPIRED >=", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredLessThan(Byte value) {
            addCriterion("ACCOUNT_NON_EXPIRED <", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredLessThanOrEqualTo(Byte value) {
            addCriterion("ACCOUNT_NON_EXPIRED <=", value, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredIn(List<Byte> values) {
            addCriterion("ACCOUNT_NON_EXPIRED in", values, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredNotIn(List<Byte> values) {
            addCriterion("ACCOUNT_NON_EXPIRED not in", values, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredBetween(Byte value1, Byte value2) {
            addCriterion("ACCOUNT_NON_EXPIRED between", value1, value2, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonExpiredNotBetween(Byte value1, Byte value2) {
            addCriterion("ACCOUNT_NON_EXPIRED not between", value1, value2, "accountNonExpired");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIsNull() {
            addCriterion("ACCOUNT_NON_LOCKED is null");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIsNotNull() {
            addCriterion("ACCOUNT_NON_LOCKED is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedEqualTo(Byte value) {
            addCriterion("ACCOUNT_NON_LOCKED =", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotEqualTo(Byte value) {
            addCriterion("ACCOUNT_NON_LOCKED <>", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedGreaterThan(Byte value) {
            addCriterion("ACCOUNT_NON_LOCKED >", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedGreaterThanOrEqualTo(Byte value) {
            addCriterion("ACCOUNT_NON_LOCKED >=", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedLessThan(Byte value) {
            addCriterion("ACCOUNT_NON_LOCKED <", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedLessThanOrEqualTo(Byte value) {
            addCriterion("ACCOUNT_NON_LOCKED <=", value, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedIn(List<Byte> values) {
            addCriterion("ACCOUNT_NON_LOCKED in", values, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotIn(List<Byte> values) {
            addCriterion("ACCOUNT_NON_LOCKED not in", values, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedBetween(Byte value1, Byte value2) {
            addCriterion("ACCOUNT_NON_LOCKED between", value1, value2, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andAccountNonLockedNotBetween(Byte value1, Byte value2) {
            addCriterion("ACCOUNT_NON_LOCKED not between", value1, value2, "accountNonLocked");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIsNull() {
            addCriterion("CREDENTIALS_NON_EXPIRED is null");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIsNotNull() {
            addCriterion("CREDENTIALS_NON_EXPIRED is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredEqualTo(Byte value) {
            addCriterion("CREDENTIALS_NON_EXPIRED =", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotEqualTo(Byte value) {
            addCriterion("CREDENTIALS_NON_EXPIRED <>", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredGreaterThan(Byte value) {
            addCriterion("CREDENTIALS_NON_EXPIRED >", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredGreaterThanOrEqualTo(Byte value) {
            addCriterion("CREDENTIALS_NON_EXPIRED >=", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredLessThan(Byte value) {
            addCriterion("CREDENTIALS_NON_EXPIRED <", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredLessThanOrEqualTo(Byte value) {
            addCriterion("CREDENTIALS_NON_EXPIRED <=", value, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredIn(List<Byte> values) {
            addCriterion("CREDENTIALS_NON_EXPIRED in", values, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotIn(List<Byte> values) {
            addCriterion("CREDENTIALS_NON_EXPIRED not in", values, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredBetween(Byte value1, Byte value2) {
            addCriterion("CREDENTIALS_NON_EXPIRED between", value1, value2, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCredentialsNonExpiredNotBetween(Byte value1, Byte value2) {
            addCriterion("CREDENTIALS_NON_EXPIRED not between", value1, value2, "credentialsNonExpired");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("ENABLED is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("ENABLED is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Byte value) {
            addCriterion("ENABLED =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Byte value) {
            addCriterion("ENABLED <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Byte value) {
            addCriterion("ENABLED >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("ENABLED >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Byte value) {
            addCriterion("ENABLED <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("ENABLED <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Byte> values) {
            addCriterion("ENABLED in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Byte> values) {
            addCriterion("ENABLED not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Byte value1, Byte value2) {
            addCriterion("ENABLED between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("ENABLED not between", value1, value2, "enabled");
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