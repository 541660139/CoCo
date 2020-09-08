package com.qw.photo.functions

import com.qw.photo.callback.DisposeCallBack
import com.qw.photo.dispose.disposer.DefaultImageDisposer
import com.qw.photo.dispose.disposer.ImageDisposer
import com.qw.photo.pojo.BaseResult
import com.qw.photo.pojo.DisposeResult
import com.qw.photo.work.DisposeWorker
import com.qw.photo.work.FunctionManager
import com.qw.photo.work.IWorker
import com.qw.photo.work.Worker
import java.io.File

/**
 *Author: 思忆
 *Date: Created in 2020/9/8 3:06 PM
 */
class DisposeBuilder(fm: FunctionManager) :
    BaseFunctionBuilder<DisposeResult>(fm) {

    private lateinit var targetFile: File

    private var disposer: ImageDisposer = DefaultImageDisposer.getDefault()

    private var callBack: DisposeCallBack? = null

    fun target(file: File): DisposeBuilder {
        this.targetFile = file
        return this
    }

    fun disposer(disposer: ImageDisposer): DisposeBuilder {
        this.disposer = disposer
        return this
    }

    fun callBack(callBack: DisposeCallBack): DisposeBuilder {
        this.callBack = callBack
        return this
    }

    override fun createWorker(): Worker {
        return DisposeWorker(functionManager.container)
    }

}