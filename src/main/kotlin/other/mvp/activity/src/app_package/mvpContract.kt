package other.mvp.activity.src.app_package

fun mvpContract(packageName:String,
                activityClass:String) = """
package ${packageName}.mvp.contract         
import ${packageName}.base.IBasePresenter    
import ${packageName}.base.IBaseView

/**
 * Created by atu on 2023.
 * @author atu
 * @description 
 */
interface C${activityClass} {

    interface IP${activityClass}: IBasePresenter
    interface IV${activityClass}: IBaseView
}
                      
"""