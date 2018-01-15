package net.webfuse.uaa.user.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoCriteria() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
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

        public Criteria andNicknameIsNull() {
            addCriterion("NICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("NICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("NICKNAME =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("NICKNAME <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("NICKNAME >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("NICKNAME >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("NICKNAME <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("NICKNAME <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("NICKNAME like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("NICKNAME not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("NICKNAME in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("NICKNAME not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("NICKNAME between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("NICKNAME not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`TYPE` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`TYPE` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`TYPE` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`TYPE` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`TYPE` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`TYPE` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`TYPE` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`TYPE` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`TYPE` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`TYPE` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`TYPE` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`TYPE` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("AVATAR is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("AVATAR is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("AVATAR =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("AVATAR <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("AVATAR >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("AVATAR >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("AVATAR <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("AVATAR <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("AVATAR like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("AVATAR not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("AVATAR in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("AVATAR not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("AVATAR between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("AVATAR not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIsNull() {
            addCriterion("REGISTER_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIsNotNull() {
            addCriterion("REGISTER_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceEqualTo(String value) {
            addCriterion("REGISTER_SOURCE =", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotEqualTo(String value) {
            addCriterion("REGISTER_SOURCE <>", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceGreaterThan(String value) {
            addCriterion("REGISTER_SOURCE >", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_SOURCE >=", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLessThan(String value) {
            addCriterion("REGISTER_SOURCE <", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_SOURCE <=", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLike(String value) {
            addCriterion("REGISTER_SOURCE like", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotLike(String value) {
            addCriterion("REGISTER_SOURCE not like", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIn(List<String> values) {
            addCriterion("REGISTER_SOURCE in", values, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotIn(List<String> values) {
            addCriterion("REGISTER_SOURCE not in", values, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceBetween(String value1, String value2) {
            addCriterion("REGISTER_SOURCE between", value1, value2, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotBetween(String value1, String value2) {
            addCriterion("REGISTER_SOURCE not between", value1, value2, "registerSource");
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

        public Criteria andStatusIsNull() {
            addCriterion("`STATUS` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`STATUS` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`STATUS` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`STATUS` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`STATUS` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`STATUS` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`STATUS` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`STATUS` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`STATUS` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`STATUS` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`STATUS` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`STATUS` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`STATUS` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`STATUS` not between", value1, value2, "status");
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