package aspects;

import larva.*;
public aspect _asp_t_login0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_t_login0.initialize();
}
}
before ( boolean value) : (call(* *.login(..)) && args(value) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_t_login0.lock){

_cls_t_login0 _cls_inst = _cls_t_login0._get_cls_t_login0_inst();
_cls_inst.value = value;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 60/*login*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 60/*login*/);
}
}
before ( boolean v) : (call(* *.log_out(..)) && args(v) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_t_login0.lock){

_cls_t_login0 _cls_inst = _cls_t_login0._get_cls_t_login0_inst();
_cls_inst.v = v;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 62/*log_out*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 62/*log_out*/);
}
}
}