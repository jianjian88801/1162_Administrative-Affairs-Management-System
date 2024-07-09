import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

         import users from '@/views/modules/users/list'
        import bangongshi from '@/views/modules/bangongshi/list'
        import bangongshiShenqing from '@/views/modules/bangongshiShenqing/list'
        import bangongwuzi from '@/views/modules/bangongwuzi/list'
        import bangongwuziShenqing from '@/views/modules/bangongwuziShenqing/list'
        import dictionary from '@/views/modules/dictionary/list'
        import huiyishi from '@/views/modules/huiyishi/list'
        import huiyishiShenqing from '@/views/modules/huiyishiShenqing/list'
        import jiaoshi from '@/views/modules/jiaoshi/list'
        import jiaoshiLizhi from '@/views/modules/jiaoshiLizhi/list'
        import jiaoshiQingjia from '@/views/modules/jiaoshiQingjia/list'
        import yinzhang from '@/views/modules/yinzhang/list'
        import yinzhangShenqing from '@/views/modules/yinzhangShenqing/list'
        import yinzhangaddShenqing from '@/views/modules/yinzhangaddShenqing/list'
        import dictionaryBangongshiShenqingYesno from '@/views/modules/dictionaryBangongshiShenqingYesno/list'
        import dictionaryBangongwuzi from '@/views/modules/dictionaryBangongwuzi/list'
        import dictionaryBangongwuziShenqingYesno from '@/views/modules/dictionaryBangongwuziShenqingYesno/list'
        import dictionaryHuiyishi from '@/views/modules/dictionaryHuiyishi/list'
        import dictionaryHuiyishiShenqingYesno from '@/views/modules/dictionaryHuiyishiShenqingYesno/list'
        import dictionaryJiaoshiLizhiYesno from '@/views/modules/dictionaryJiaoshiLizhiYesno/list'
        import dictionaryJiaoshiQingjiaYesno from '@/views/modules/dictionaryJiaoshiQingjiaYesno/list'
        import dictionarySex from '@/views/modules/dictionarySex/list'
        import dictionaryYinzhangShenqingYesno from '@/views/modules/dictionaryYinzhangShenqingYesno/list'
        import dictionaryYinzhangaddShenqingYesno from '@/views/modules/dictionaryYinzhangaddShenqingYesno/list'
        import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBangongshiShenqingYesno',
        name: '办公室审核',
        component: dictionaryBangongshiShenqingYesno
    }
    ,{
        path: '/dictionaryBangongwuzi',
        name: '办公物资类型',
        component: dictionaryBangongwuzi
    }
    ,{
        path: '/dictionaryBangongwuziShenqingYesno',
        name: '办公物资审核',
        component: dictionaryBangongwuziShenqingYesno
    }
    ,{
        path: '/dictionaryHuiyishi',
        name: '会议室类型',
        component: dictionaryHuiyishi
    }
    ,{
        path: '/dictionaryHuiyishiShenqingYesno',
        name: '会议室审核',
        component: dictionaryHuiyishiShenqingYesno
    }
    ,{
        path: '/dictionaryJiaoshiLizhiYesno',
        name: '离职审核',
        component: dictionaryJiaoshiLizhiYesno
    }
    ,{
        path: '/dictionaryJiaoshiQingjiaYesno',
        name: '请假审核',
        component: dictionaryJiaoshiQingjiaYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYinzhangShenqingYesno',
        name: '印章审核',
        component: dictionaryYinzhangShenqingYesno
    }
    ,{
        path: '/dictionaryYinzhangaddShenqingYesno',
        name: '印章添加审核',
        component: dictionaryYinzhangaddShenqingYesno
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '状态',
        component: dictionaryZhuangtai
    }


    ,{
        path: '/bangongshi',
        name: '办公室',
        component: bangongshi
      }
    ,{
        path: '/bangongshiShenqing',
        name: '办公室申请',
        component: bangongshiShenqing
      }
	  
    ,{
        path: '/bangongwuzi',
        name: '办公物资',
        component: bangongwuzi
      }
    ,{
        path: '/bangongwuziShenqing',
        name: '办公物资申请',
        component: bangongwuziShenqing
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/huiyishi',
        name: '会议室',
        component: huiyishi
      }
    ,{
        path: '/huiyishiShenqing',
        name: '会议室申请',
        component: huiyishiShenqing
      }
    ,{
        path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
    ,{
        path: '/jiaoshiLizhi',
        name: '离职申请',
        component: jiaoshiLizhi
      }
    ,{
        path: '/jiaoshiQingjia',
        name: '请假申请',
        component: jiaoshiQingjia
      }
    ,{
        path: '/yinzhang',
        name: '印章',
        component: yinzhang
      }
    ,{
        path: '/yinzhangShenqing',
        name: '印章申请',
        component: yinzhangShenqing
      }
    ,{
        path: '/yinzhangaddShenqing',
        name: '印章添加申请',
        component: yinzhangaddShenqing
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
