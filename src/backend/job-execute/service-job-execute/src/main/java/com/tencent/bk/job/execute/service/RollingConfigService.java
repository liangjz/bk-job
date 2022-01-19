/*
 * Tencent is pleased to support the open source community by making BK-JOB蓝鲸智云作业平台 available.
 *
 * Copyright (C) 2021 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-JOB蓝鲸智云作业平台 is licensed under the MIT License.
 *
 * License for BK-JOB蓝鲸智云作业平台:
 * --------------------------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */

package com.tencent.bk.job.execute.service;

import com.tencent.bk.job.common.model.dto.IpDTO;
import com.tencent.bk.job.execute.model.FastTaskDTO;
import com.tencent.bk.job.execute.model.StepInstanceBaseDTO;
import com.tencent.bk.job.execute.model.TaskInstanceRollingConfigDTO;

import java.util.List;

/**
 * 滚动配置服务
 */
public interface RollingConfigService {
    /**
     * 获取步骤当前批次对应的主机
     *
     * @param stepInstance 步骤实例
     * @return 主机列表
     */
    List<IpDTO> getRollingServers(StepInstanceBaseDTO stepInstance);

    /**
     * 获取步骤当前批次对应的主机
     *
     * @param stepInstanceId 步骤实例ID
     * @param batch          滚动执行批次
     * @return 主机列表
     */
    List<IpDTO> getRollingServers(long stepInstanceId, int batch);

    /**
     * 保存快速执行作业滚动配置
     *
     * @param fastTask 快速执行作业
     * @return 滚动配置ID
     */
    long saveRollingConfigForFastJob(FastTaskDTO fastTask);

    TaskInstanceRollingConfigDTO getRollingConfig(long rollingConfigId);
}
