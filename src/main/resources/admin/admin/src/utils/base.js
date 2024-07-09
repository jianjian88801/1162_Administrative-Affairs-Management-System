const base = {
    get() {
        return {
            url : "http://localhost:8080/gaoxiaobangongxingzheng/",
            name: "gaoxiaobangongxingzheng",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gaoxiaobangongxingzheng/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校办公室行政事务管理"
        } 
    }
}
export default base
