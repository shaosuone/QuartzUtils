package com.hyr.quartz.demo.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*******************************************************************************
 * @date 2018-11-11 下午 11:11
 * @author: <a href=mailto:huangyr@bonree.com>黄跃然</a>
 * @Description: JobListener 任务监听器
 ******************************************************************************/
public class DefaultJobListener implements JobListener {

    private static Logger log = LoggerFactory.getLogger(DefaultJobListener.class);

    private String name; // 监听器名称

    @Override
    public String getName() {
        return this.name;
    }

    public DefaultJobListener(String name) {
        this.name = name;
    }

    /**
     * job 将要被执行时调用这个方法。
     *
     * @param jobExecutionContext
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        log.info(getName() + " - the job:{} is will to exec.", jobName);
    }

    /**
     * 即将被执行，但又被 TriggerListener 否决了时调用这个方法。
     *
     * @param jobExecutionContext
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        log.warn(getName() + " - the job:{} is vetoed.", jobName);
    }


    /**
     * job 被执行之后调用这个方法。
     *
     * @param jobExecutionContext
     * @param e
     */
    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        log.info(getName() + " - the job:{} is exec success.", jobName);
    }

}