package other.mvp.activity.src.app_package


fun mvpActivityKt(
    applicationPackage:String?,
    activityClass:String,
    layoutName:String,
    packageName:String
)="""
package ${packageName}.mvp.activity
import ${packageName}.mvp.contract.C${activityClass}
import ${packageName}.mvp.presenter.P${activityClass}Impl
import ${packageName}.base.BaseActivity
import ${packageName}.R

/**
 * Created by atu on 2023.
 * @author atu
 * @description 
 */
class ${activityClass}Activity: BaseActivity<P${activityClass}Impl>(),C${activityClass}.IV${activityClass} {

    override fun setContentViewId() = R.layout.${layoutName}
    
    override fun initView() {
      	
    }

     override fun createPresenter() {
        mPresenter = P${activityClass}Impl(mContext, this)
     }
	
    override fun showLoading() {

    }

    override fun hideLoading() {

    }
} 
"""