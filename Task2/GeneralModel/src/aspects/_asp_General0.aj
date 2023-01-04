package aspects;

import larva.*;
public aspect _asp_General0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_General0.initialize();
}
}
before () : (call(* *.log_in(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_General0.lock){

_cls_General0 _cls_inst = _cls_General0._get_cls_General0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 14/*log_in*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 14/*log_in*/);
}
}
before () : (call(* *.delete_alerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_General0.lock){

_cls_General0 _cls_inst = _cls_General0._get_cls_General0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 20/*delete_alerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 20/*delete_alerts*/);
}
}
before () : (call(* *.log_out(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_General0.lock){

_cls_General0 _cls_inst = _cls_General0._get_cls_General0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 16/*log_out*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 16/*log_out*/);
}
}
before () : (call(* *.view_alerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_General0.lock){

_cls_General0 _cls_inst = _cls_General0._get_cls_General0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 22/*view_alerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 22/*view_alerts*/);
}
}
before () : (call(* *.invalid_login(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_General0.lock){

_cls_General0 _cls_inst = _cls_General0._get_cls_General0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 12/*invalid_login*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 12/*invalid_login*/);
}
}
before () : (call(* *.create_alert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_General0.lock){

_cls_General0 _cls_inst = _cls_General0._get_cls_General0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 18/*create_alert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 18/*create_alert*/);
}
}
}