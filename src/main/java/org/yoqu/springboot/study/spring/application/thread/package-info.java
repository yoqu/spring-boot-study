/**
 * @author yoqu
 * @date 2017年05月05
 * @time 下午4:48
 * @email wcjiang2@iflytek.com
 * 多线程使用说明:
 *  1. 需要一个实现AsyncConfigurer接口并且启用EnableAsync注解,
 *  2. 在需要使用多线程的方法上加上@Async注解即可实现简单的异步调用
 */
package org.yoqu.springboot.study.spring.application.thread;