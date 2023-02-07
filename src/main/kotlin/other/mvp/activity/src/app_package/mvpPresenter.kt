package other.mvp.activity.src.app_package

fun mvpPresenter(
    packageName:String,
    activityClass:String
) = """
package ${packageName}.mvp.presenter
import ${packageName}.mvp.contract.C${activityClass};
import ${packageName}.mvp.model.M${activityClass}Impl;
import ${packageName}.base.BasePresenter
import android.content.Context

/**
 * Created by atu on 2023.
 * @author atu
 * @description 
 */
class P${activityClass}Impl(mContext: Context,mView: C${activityClass}.IV${activityClass}): 
BasePresenter<C${activityClass}.IV${activityClass}, M${activityClass}Impl>(mContext,mView,M${activityClass}Impl()), C${activityClass}.IP${activityClass} {

}


"""