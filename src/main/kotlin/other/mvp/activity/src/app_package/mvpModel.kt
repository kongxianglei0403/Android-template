package other.mvp.activity.src.app_package

fun mvpModel(
    packageName:String,
    activityClass:String) = """
package ${packageName}.mvp.model
import ${packageName}.base.BaseModel

/**
 * Created by atu on 2023.
 * @author atu
 * @description 
 */
class M${activityClass}Impl : BaseModel<*>() {

}

"""