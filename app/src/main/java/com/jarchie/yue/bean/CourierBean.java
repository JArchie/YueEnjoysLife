package com.jarchie.yue.bean;

import java.util.List;

/**
 * Created by Jarchie on 2018\2\8.
 * 快递查询的实体
 */

public class CourierBean {

    /**
     * resultcode : 200
     * reason : 查询物流信息成功
     * result : {"company":"EMS","com":"ems","no":"1059105904127","status":"0","list":[{"datetime":"2018-01-28 17:30:00","remark":"杭州市邮政速递物流公司萧山区火车南站揽投站已收件（揽投员姓名：楼吉敏,联系电话:）【杭州市】","zone":""},{"datetime":"2018-01-28 18:20:16","remark":"已离开杭州市邮政速递物流公司萧山区火车南站揽投站，发往杭州陆运转运中心【杭州市】","zone":""},{"datetime":"2018-01-29 16:10:04","remark":"杭州市邮政速递物流公司萧山区火车南站揽投站安排投递，预计23:59:00前投递（投递员姓名：楼吉敏;联系电话：17706717516）【杭州市】","zone":""},{"datetime":"2018-01-29 16:10:29","remark":"退回 妥投【杭州市】","zone":""}]}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * company : EMS
         * com : ems
         * no : 1059105904127
         * status : 0
         * list : [{"datetime":"2018-01-28 17:30:00","remark":"杭州市邮政速递物流公司萧山区火车南站揽投站已收件（揽投员姓名：楼吉敏,联系电话:）【杭州市】","zone":""},{"datetime":"2018-01-28 18:20:16","remark":"已离开杭州市邮政速递物流公司萧山区火车南站揽投站，发往杭州陆运转运中心【杭州市】","zone":""},{"datetime":"2018-01-29 16:10:04","remark":"杭州市邮政速递物流公司萧山区火车南站揽投站安排投递，预计23:59:00前投递（投递员姓名：楼吉敏;联系电话：17706717516）【杭州市】","zone":""},{"datetime":"2018-01-29 16:10:29","remark":"退回 妥投【杭州市】","zone":""}]
         */

        private String company;
        private String com;
        private String no;
        private String status;
        private List<ListBean> list;

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getCom() {
            return com;
        }

        public void setCom(String com) {
            this.com = com;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * datetime : 2018-01-28 17:30:00
             * remark : 杭州市邮政速递物流公司萧山区火车南站揽投站已收件（揽投员姓名：楼吉敏,联系电话:）【杭州市】
             * zone :
             */

            private String datetime;
            private String remark;
            private String zone;

            public String getDatetime() {
                return datetime;
            }

            public void setDatetime(String datetime) {
                this.datetime = datetime;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getZone() {
                return zone;
            }

            public void setZone(String zone) {
                this.zone = zone;
            }
        }
    }
}
