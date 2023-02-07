package other.mvp.fragment.src.app_package

import com.android.tools.idea.wizard.template.PackageName

/**
 *@Description
 *@author          阿土
 *@create          2023-02-07 13:28
 */
fun mvpFragmentKt(applicationPackage: PackageName?,
                  fragmentClass: String, layoutName:
                  String, packageName: String) = """
package ${packageName}.mvp.fragment
import ${packageName}.mvp.contract.C${fragmentClass}
import ${packageName}.mvp.presenter.P${fragmentClass}Impl
import ${packageName}.base.BaseFragment
import ${packageName}.R
import android.os.Bundle

/**
 * Created by atu on 2023.
 * @author atu
 * @description 
 */
class ${fragmentClass}Fragment: BaseFragment<P${fragmentClass}Impl>(), C${fragmentClass}.IV${fragmentClass}{

    override fun getLayoutRes() = R.layout.${layoutName}
    
    override fun initView() {
        		
    }
	
    override fun createPresenter() {
        mPresenter = P${fragmentClass}Impl(mContext, this);
    }
	
    override fun showLoading() {
    
    }

    override fun hideLoading() {
    
    }
    
    companion object {
        fun newInstance() = ${fragmentClass}Fragment().apply { 
                arguments = Bundle()
        }
	}	
}
"""